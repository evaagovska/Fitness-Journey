import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './components/homepage/homepage.component';
import { JournalComponent } from './components/journal/journal.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { MuscleDetailsComponent } from './components/muscle-details/muscle-details.component';

const routes: Routes = [

  {path: '', component: HomepageComponent },
  {path: 'muscles', component: HomepageComponent },
  {path: 'journal', component: JournalComponent },
  {path: 'sign-up', component: SignupComponent },
  {path: 'log-in', component: LoginComponent },
  {path: 'muscle/:id', component: MuscleDetailsComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
