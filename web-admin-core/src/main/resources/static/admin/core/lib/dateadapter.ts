import {NativeDateAdapter} from '@angular/material';


export class AppDateAdapter extends NativeDateAdapter {
    format(date: Date, displayFormat: Object): string {
        if (displayFormat === 'input') {
            const day = date.getUTCDate();
            const month = date.getUTCMonth() + 1;
            const year = date.getFullYear();
            return `${day}-${month}-${year}`;
        } else {
            return date.toDateString();
        }
    }
}

export const APP_DATE_FORMATS = {
    parse: {
        dateInput: {month: 'short', year: 'numeric', day: 'numeric'}
    },
    display: {
        dateInput: 'input',
        monthYearLabel: {year: 'numeric', month: 'short'},
        dateA11yLabel: {year: 'numeric', month: 'long', day: 'numeric'},
        monthYearA11yLabel: {year: 'numeric', month: 'long'},
    }
};