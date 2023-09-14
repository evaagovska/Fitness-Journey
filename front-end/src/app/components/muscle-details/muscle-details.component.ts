import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {MuscleService} from '../../services/muscle.service';
import {PageEvent} from '@angular/material/paginator';
import {flatMap, of} from 'rxjs';

@Component({
    selector: 'app-muscle-details',
    templateUrl: './muscle-details.component.html',
    styleUrls: ['./muscle-details.component.css']
})
export class MuscleDetailsComponent implements OnInit {
    muscleId: number = 0;
    exercises: any[] = [];
    muscle: any | null = null;

    currentPage: number = 0;
    pageSize: number = 5;
    totalItems: number = 0;

    constructor(
        private route: ActivatedRoute,
        private muscleService: MuscleService
    ) {
    }

    ngOnInit(): void {
        this.muscleId = Number(this.route.snapshot.paramMap.get('id'))
        this.fetchExercisesByMuscleId();
    }

    fetchExercisesByMuscleId(): void {
        this.muscleService.getMuscleById(this.muscleId).pipe(flatMap(
            res => {
                this.muscle = res
                this.currentPage = 0
                this.fetchExercisesWithPagination()
                return of(res)
            })).subscribe()

    }

    fetchExercisesWithPagination(): void {
        this.muscleService.getExercisesFromMuscle(this.muscleId, this.currentPage, this.pageSize)
            .subscribe({
                next: data => {
                    this.exercises = data.content;
                    this.totalItems = data.totalElements;
                },
                error: error => {
                    console.log(error);
                }
            });
    }

    onPageChange(event: PageEvent): void {
        this.currentPage = event.pageIndex;
        this.pageSize = event.pageSize;
        this.fetchExercisesWithPagination();
    }
}

