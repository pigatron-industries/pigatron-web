CKEDITOR.plugins.add('pgimage', {
    icons: 'pgimage',
    init: function( editor ) {
        editor.addCommand('pgimage', {
            exec: function(editor) {
                //call function on controller to open material dialog
                $("form").controller().showImageDialog();
            }
        });
        editor.ui.addButton('pgImage', {
            label: 'Insert Image',
            command: 'pgimage',
            toolbar: 'insert'
        });
    }
});