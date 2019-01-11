import { Component, OnInit, Input } from '@angular/core';
import { TodoService } from '../service/todo.service';
import { Todo } from '../../shared/Todo';
import { Router } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  todo : Todo

  constructor(private todoService : TodoService, private router : Router) { }

  ngOnInit() {
    this.todo = new Todo()
  }

  saveTodo() {
    this.todoService.createTodo(this.todo).subscribe(
      x => {
        this.router.navigate(["todo-list"]);
      }
    )
  }
}
