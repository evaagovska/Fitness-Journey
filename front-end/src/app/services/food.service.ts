import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const PATH = 'http://localhost:8080/api/foods';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
};


@Injectable({
    providedIn: 'root',
})
export class FoodService {
    constructor(private http: HttpClient) {}

    getFoodOptions(name:string):Observable<any> {
        return this.http.get(`${PATH}/name/${name}`)
    }
    getFoodById(id:number):Observable<any> {
        return this.http.get(`${PATH}/id/${id}`)
    }


}