
CKEDITOR.editorConfig = function( config ) {
    // Define changes to default configuration here.
    // For complete reference see:
    // http://docs.ckeditor.com/#!/api/CKEDITOR.config
    config.skin = 'pigatron';
    config.extraPlugins = 'wpmore,pgimage';

    config.toolbar = [
        { name: 'clipboard', items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
        { name: 'tools', items: [ 'Maximize' ] },
        '/',
        { name: 'styles', items: [ 'Styles', 'Format', '-' ] },
        { name: 'basicstyles', items: [ 'Bold', 'Italic', 'Strike', '-', 'RemoveFormat', '-' ] },
        { name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-' ] },
        { name: 'links', items: [ 'Link', 'Unlink', '-' ] },
        { name: 'insert', items: [ 'Table', 'HorizontalRule', 'SpecialChar', 'pgImage', 'WPMore' ] },
        { name: 'document', items: [ 'Source' ] }
    ];

    config.removeButtons = 'Underline,Subscript,Superscript,About,Anchor,Scayt';

    // Set the most common block elements.
    config.format_tags = 'p;h1;h2;h3;pre';

    // Simplify the dialog windows.
    //config.removeDialogTabs = 'image:advanced;link:advanced';

    //config.filebrowserUploadUrl = '/test/uploader';
    //config.filebrowserBrowseUrl = '/test/browser';

};
