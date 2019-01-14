import { Component, OnInit, Input } from '@angular/core';
import { TodoService } from '../service/todo.service';
import { Todo } from '../../shared/Todo';
import { Router } from '@angular/router';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  constructor(private todoService : TodoService, private route : Router) { }

  todoes:Todo[]
  onDeleteMessage : string

  ngOnInit() {
    this.refreshPage()
  }

  getTodoForm() {
    this.route.navigate(['todos', -1])
  }

  deleteTodo(id) {
    this.todoService.deleteTodo(id).subscribe(
      x=> {
        this.refreshPage();
        this.onDeleteMessage = `Todo with id: ${id} has been deleted`
      })
  }

  refreshPage() {
    this.todoService.retriveTodos().subscribe(
      x=> {
        this.todoes = x;
      }
    )
  }
}
