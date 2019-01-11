import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodoListComponent } from '../todo-list/todo-list.component';
import { TodoComponent } from '../todo/todo.component';



const routes: Routes = [
  {
    path: '', component: TodoListComponent
  },
  {
    path: 'todos/:id', component: TodoComponent
  },
  {
    path: 'todo-list', component: TodoListComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }