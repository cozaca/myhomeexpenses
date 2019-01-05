import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.css']
})
export class ExpenseComponent implements OnInit {

  expenses: any

  constructor(private http: HttpClient) { }

  ngOnInit() {

    this.http.get('/expenses').subscribe( data => {
      this.expenses = data;
    })
  }

}
