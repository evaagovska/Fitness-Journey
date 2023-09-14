import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MuscleService } from 'src/app/services/muscle.service';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  muscles: any[] | undefined;

images:string[]=[
  '../../../assets/images/biceps.jpg',
  '../../../assets/images/forearm.jpg',
  '../../../assets/images/shoulder.jpg',
  '../../../assets/images/triceps.jpeg',
  '../../../assets/images/quads1.jpg',
  '../../../assets/images/glutes.jpg',
  '../../../assets/images/lats.jpg',
  '../../../assets/images/mid-back.jpg',
  '../../../assets/images/lowerback1.jpg',
  '../../../assets/images/hamstings.jpg',
  '../../../assets/images/chest.jpg',
  '../../../assets/images/abdominal.jpg',
  '../../../assets/images/obliques.jpg',
  '../../../assets/images/traps.jpeg',
  '../../../assets/images/calves.jpg',
  
]

  constructor(private http: HttpClient,private muscleService:MuscleService) { }

  ngOnInit(): void {
    this.fetchMuscles();
  }

  fetchMuscles(): void {
    this.muscleService.getMuscles().subscribe({
      next: response => {

        this.muscles=response
      
      },  error: error => {
        console.log(error)
    
      }})};

}