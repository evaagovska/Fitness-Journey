import { Food } from "./Food";
import { Journal } from "./Journal";

export class FoodHistory {
    id: number = 0
    food: Food = new Food()
    portion_size: number = 100.0
    date: string = new Date().toISOString().split('T')[0]
    journal : Journal = new Journal ()
}