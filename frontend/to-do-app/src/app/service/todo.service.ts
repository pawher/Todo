import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Todo } from '../../shared/Todo';

@Injectable()
export class TodoService {

  END_POINT : string

  constructor(private httpClient : HttpClient) {
    this.END_POINT = "http://localhost:8080/"
   }

   retriveTodos() {
    return this.httpClient.get<Todo[]>("http://localhost:8080/tasks")
  }
}
