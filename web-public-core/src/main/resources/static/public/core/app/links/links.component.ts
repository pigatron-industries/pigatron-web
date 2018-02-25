// import {Component, OnInit} from "@angular/core";
// import {ROUTER_DIRECTIVES} from "@angular/router";
// import {MD_TABS_DIRECTIVES} from "@angular2-material/tabs";
// import {SettingsService} from "../settings/settings.service";
//
//
// @Component({
//     selector: 'pg-links',
//     templateUrl: '/public/core/app/links/links.component.html',
//     directives: [MD_TABS_DIRECTIVES, ROUTER_DIRECTIVES],
//     providers: [SettingsService]
// })
// export class LinksComponent implements OnInit {
//
//     public loaded: boolean = false;
//     public settings: any;
//
//
//     constructor(private settingsService : SettingsService) {
//     }
//
//     ngOnInit() {
//         this.load();
//     }
//
//     load() {
//         this.settingsService.get("website")
//             .subscribe(settings => {
//                 this.settings = settings;
//                 this.loaded = true;
//             });
//     }
//
// }