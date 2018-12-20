
class MyUploadAdapter {
    constructor( loader, url ) {
        // The FileLoader instance to use during the upload. It sounds scary but do not
        // worry — the loader will be passed into the adapter later on in this guide.
        this.loader = loader;

        // The upload URL in your server back-end. This is the address the XMLHttpRequest
        // will send the image data to.
        this.url = url;
    }

    // ...
}


function MyCustomUploadAdapterPlugin( editor ) {
    editor.plugins.get( 'FileRepository' ).createUploadAdapter = ( loader ) => {
        // Configure the URL to the upload script in your back-end here!
        return new MyUploadAdapter( loader, 'http://example.com/image/upload/path' );
    };
}