import { Component, OnInit } from '@angular/core';
import { TodoService } from '../service/todo.service';
import { Todo } from '../../shared/Todo';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  constructor(private todoService : TodoService) { }

  todoes:Todo[]

  ngOnInit() {
    this.refreshPage()
  }

  refreshPage() {
    this.todoService.retriveTodos().subscribe(
      x=> {
        this.todoes = x;
      }
    )
  }
}
