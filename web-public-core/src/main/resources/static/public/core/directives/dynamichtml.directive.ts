import {
    Directive,
    Component,
    Input,
    ComponentResolver,
    ComponentMetadata,
    ComponentFactory,
    ViewContainerRef,
    ReflectiveInjector
} from "@angular/core";


//noinspection TypeScriptUnresolvedVariable
export function createComponentFactory(resolver: ComponentResolver, metadata: ComponentMetadata): Promise<ComponentFactory<any>> {
    const cmpClass = class DynamicComponent {};
    const decoratedCmp = Component(metadata)(cmpClass);
    return resolver.resolveComponent(decoratedCmp);
}


@Directive({
    selector: 'pg-dynamic-html',
})
export class DynamicHTMLDirective {
    @Input() src: string;

    constructor(private vcRef: ViewContainerRef, private resolver: ComponentResolver) {
    }

    ngOnChanges() {
        if (!this.src) return;

        const metadata = new ComponentMetadata({
            selector: 'dynamic-html',
            template: this.src,
        });
        createComponentFactory(this.resolver, metadata)
            .then(factory => {
                const injector = ReflectiveInjector.fromResolvedProviders([], this.vcRef.parentInjector);
                this.vcRef.createComponent(factory, 0, injector, []);
            });
    }
}