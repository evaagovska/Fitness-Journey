import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/User';
import { Journal } from "../model/Journal";

const PATH_AUTH = 'http://localhost:8080/api/';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
};
const USER_KEY = 'auth-user';

@Injectable({
    providedIn: 'root',
})
export class JournalService {

    constructor(private http: HttpClient) { }

    getJournal(): Observable<any> {
        return this.http.get(`${PATH_AUTH}auth/journal`, httpOptions);
    }

    updateJournal(journal: Journal): Observable<any> {
        return this.http.post(`${PATH_AUTH}auth/journal/update`, journal);
    }

    calculateRequiredCalories(user: User, journal: Journal): number {

        let timeDiff = Math.abs(Date.now() - Date.parse(user.dateOfBirth!))
        let age = Math.floor((timeDiff / (1000 * 3600 * 24)) / 365.25);
        let calories: number = 0;
        if (user.gender == "FEMALE") {
            calories = 655 + (9.6 * journal.weight) + (1.8 * journal.height) - (4.7 * age)
            if (journal.goal == "GAIN") {
                calories = calories + 300
            }
            else if (journal.goal == "LOSE_WEIGHT") {
                calories = calories - 300
            }
        }
        else {
            calories = 66 + (13.7 * journal.weight) + (5 * journal.height) - (6.8 * age)
            if (journal.goal == "GAIN") {
                calories = calories + 500
            }
            else if (journal.goal == "LOSE_WEIGHT") {
                calories = calories - 500
            }

        }

        if (journal.activity == "LIGHT") {
            calories = calories * 1.375
        }
        else if (journal.activity == "MODERATE") {
            calories = calories * 1.55
        }
        else if (journal.activity == "ACTIVE") {
            calories = calories * 1.725
        }

        return parseFloat(calories.toFixed(2))
    }
}
