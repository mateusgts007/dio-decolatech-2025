import { Injectable } from '@angular/core';
import { Post } from '../models/post.model';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  private posts: Post[] = [
    {
      id: 1,
      title: 'Primeiro Post',
      content: 'Este é o conteúdo do primeiro post.',
      author: 'Autor 1',
      date: '2023-10-01',
    },
    {
      id: 2,
      title: 'Segundo Post',
      content: 'Este é o conteúdo do segundo post.',
      author: 'Autor 2',
      date: '2023-10-02',
    },
  ];

  getPosts(): Post[] {
    return this.posts;
  }

  getPostById(id: number): Post | undefined {
    return this.posts.find((post) => post.id === id);
  }
}