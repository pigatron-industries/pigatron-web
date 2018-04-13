
export interface MenuAction {
    type: string;
    action: string;
}

export interface MenuItem {
    id: string;
    name: string;
    action: MenuAction;
    submenus?: MenuItem[];
}