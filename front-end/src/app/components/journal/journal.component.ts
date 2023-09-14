import {Component, OnInit} from '@angular/core';
import {Journal} from 'src/app/model/Journal';
import {NgForm} from '@angular/forms';
import {FoodService} from "../../services/food.service";
import {Food} from "../../model/Food";
import {flatMap, of} from "rxjs";
import {JournalService} from "../../services/journal.service";
import {UserService} from "../../services/user.service";
import {FoodHistoryService} from "../../services/food-history.service";
import {FoodHistory} from 'src/app/model/FoodHistory';
import {EnterFood} from 'src/app/model/EnterFood';
import {User} from 'src/app/model/User';

@Component({
    selector: 'app-journal',
    templateUrl: './journal.component.html',
    styleUrls: ['./journal.component.css']
})
export class JournalComponent implements OnInit {

    journal: Journal = new Journal()
    totalCalories: number = 0
    totalRequired: number = 0
    user: User = new User()

    isLoggedIn = false;


    searchFood: string = '';
    options: Food[] = [];


    dailyFoodArr: FoodHistory[] = []

    enterFoodModel: EnterFood = new EnterFood()

    selectedDate: string = this.getCurrentDate();

    constructor(private journalService: JournalService, private foodService: FoodService, private userService: UserService, private foodHistory: FoodHistoryService) {
    }

    ngOnInit() {

        this.isLoggedIn = this.userService.isLoggedIn()
        this.user = this.userService.getUser();
        this.journalService.getJournal().pipe(flatMap(
            res => {
                this.journal = res
                this.totalRequired = this.journalService.calculateRequiredCalories(this.userService.getUser(), this.journal)
                this.loadFood()
                return of(res)
            }
        )).subscribe()


    }

    save(form: NgForm) {
        this.journalService.updateJournal(this.journal).pipe(flatMap(
            res => {
                this.totalRequired = this.journalService.calculateRequiredCalories(this.userService.getUser(), this.journal)
                return of(res)
            }
        )).subscribe()

    }

    listFood() {
        this.foodService.getFoodOptions(this.searchFood).subscribe({
            next: data => {
                this.options = data;
                this.enterFoodModel = {
                    intakeSize: 100,
                    selectedOption: this.options[0].id
                }
            },
            error: err => {
                console.log(err)
            }
        })

    }

    getCurrentDate(): string {
        const today = new Date();
        const year = today.getFullYear();
        const month = String(today.getMonth() + 1).padStart(2, '0');
        const day = String(today.getDate()).padStart(2, '0');

        return `${year}-${month}-${day}`;
    }


    loadFood() {
        this.foodHistory.getFoodHistoryByDate(this.selectedDate, this.journal.id).subscribe(
            response => {
                this.totalCalories = 0;
                this.dailyFoodArr = response.map((e: any) => {
                    e.food.calories = e.food.calories * e.portion_size / 100;
                    e.food.proteins = (parseFloat(e.food.proteins.split(" ")[0]) * e.portion_size / 100).toFixed(2);
                    e.food.carbohydrates = (parseFloat(e.food.carbohydrates.split(" ")[0]) * e.portion_size / 100).toFixed(2);
                    e.food.fats = (parseFloat(e.food.fats.split("g")[0]) * e.portion_size / 100).toFixed(2);
                    this.totalCalories += e.food.calories;
                    return e;
                });
            },
            error => {
                console.log(error);
            }
        );
    }

    enterFood() {

        let dailyFood = new FoodHistory()

        this.foodService.getFoodById(this.enterFoodModel.selectedOption).pipe(flatMap(
            food => {
                dailyFood.food = food
                dailyFood.portion_size = this.enterFoodModel.intakeSize;
                dailyFood.journal = this.journal
                this.foodHistory.updateFoodHistory(dailyFood).pipe(flatMap(
                    res => {
                        this.loadFood()
                        return of(res)
                    })).subscribe()
                return of(food)
            }
        )).subscribe()

    }


    onDateChange() {
        this.loadFood()
    }

    deleteFood(id: number) {

        this.foodHistory.deleteFoodById(id).pipe(flatMap(
            res => {
                this.loadFood()
                return of(res)
            }
        )).subscribe()

    }


}