import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const PATH_AUTH = 'http://localhost:8080/api';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
};

@Injectable({
    providedIn: 'root',
})
export class MuscleService {
    constructor(private http: HttpClient) {}

    getMuscles(): Observable<any> {
        return this.http.get(`${PATH_AUTH}/muscles`, httpOptions);
    }

    getMuscleById(id: number): Observable<any> {
        return this.http.get(`${PATH_AUTH}/muscles/${id}`,httpOptions);
    }

    getExercisesFromMuscle(id: number, page: number, pageSize: number): Observable<any> {
        const url = `${PATH_AUTH}/exercises/muscle/${id}?page=${page}&size=${pageSize}`;
        return this.http.get(url, httpOptions);
    }
}
