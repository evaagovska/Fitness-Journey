import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {  Observable } from 'rxjs';
import { FoodHistory } from "../model/FoodHistory";

const PATH = 'http://localhost:8080/api/auth/food-history';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
};


@Injectable({
    providedIn: 'root',
})
export class FoodHistoryService {

    constructor(private http: HttpClient) { }

    updateFoodHistory(dailyFood: FoodHistory): Observable<any> {
        return this.http.post(`${PATH}/update`, dailyFood);
    }

    getFoodHistoryByDate(date: string, journalId: number): Observable<any> {
        return this.http.get(`${PATH}/date/${date}/${journalId}`, httpOptions)
    }

    deleteFoodById(id: number): Observable<any> {
        return this.http.post(`${PATH}/delete/${id}`, httpOptions)
    }

}
