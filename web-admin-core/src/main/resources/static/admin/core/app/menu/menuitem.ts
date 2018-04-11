export interface MenuItem {
    id: string;
    name: string;
    submenus?: MenuItem[];
}