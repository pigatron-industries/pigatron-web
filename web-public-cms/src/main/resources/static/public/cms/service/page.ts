import {Content} from './content';

export class Page extends Content {
    type = 'Page';
    title: string;
    urlKey: string;
}