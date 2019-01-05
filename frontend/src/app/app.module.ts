import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExpenseComponent } from './expense/expense.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

const appRoutes: Routes = [
  {
    path: 'expense',
    component: ExpenseComponent,
    data: {title: 'Expenses'}
  },
  {
    path: '',
    redirectTo: '/expense',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    ExpenseComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} //debugging only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
