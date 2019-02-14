import { Component, OnInit, Input } from '@angular/core';
import { TodoService } from '../service/todo.service';
import { Todo } from '../../shared/Todo';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  todo: Todo
  registerForm: FormGroup;
  submitted = false;

  constructor(private todoService: TodoService, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.todo = new Todo()
    this.registerForm = this.formBuilder.group({
      desc: ['', Validators.required],
      status: ['', Validators.required]
    });
  }

  get f() { return this.registerForm.controls; }
  
  saveTodo() {
    this.submitted = true;

    if (this.registerForm.invalid) {
        return;
    }

    this.todo.descripton = this.registerForm.value.desc;
    this.todo.status = this.registerForm.value.status;
    this.todoService.createTodo(this.todo).subscribe(
      x => {
        this.router.navigate(["todo-list"]);
      }
    )
  }
}
