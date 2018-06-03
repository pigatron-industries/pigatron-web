import {Content} from './content';

export class Post extends Content {
    type = 'Post';
    title: string;
    publishedDate: Date;
}