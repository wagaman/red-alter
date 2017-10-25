"use strict";
var page = require('webpage').create(),
    system = require('system'),
    address, output, size;

try{	

	if (system.args.length < 3 || system.args.length > 5) {		
		console.log('error');
		phantom.exit(1);
	} else {
		address = system.args[1];
		output = system.args[2];
		page.viewportSize = { width: 600, height: 600 };
		if (system.args.length > 3 && system.args[2].substr(-4) === ".pdf") {
			size = system.args[3].split('*');
			page.paperSize = size.length === 2 ? { width: size[0], height: size[1], margin: '0px' }
											   : { format: system.args[3], orientation: 'portrait', margin: '1cm' };
		} else if (system.args.length > 3 && system.args[3].substr(-2) === "px") {
            size = system.args[3].split('*');
			var pageWidth,pageHeight;
			if (size.length === 2) {
				pageWidth = parseInt(size[0], 10);
				pageHeight = parseInt(size[1], 10);
				page.viewportSize = { width: pageWidth, height: pageHeight };
				page.clipRect = { top: 150, left: 0, width: pageWidth, height: pageHeight };
			} else {
				console.log("size:", system.args[3]);
				pageWidth = parseInt(system.args[3], 10);
				pageHeight = parseInt(pageWidth * 3/4, 10); // it's as good an assumption as any
				console.log ("pageHeight:",pageHeight);
				page.viewportSize = { width: pageWidth, height: pageHeight };
			}
		}
		if (system.args.length > 4) {
			page.zoomFactor = system.args[4];
		}


		var start = Date.now();
        page.open(address, function (status) {
            console.log("open cost " + (Date.now() - start) + " ms")
            start = Date.now();
            if (status !== 'success') {
                console.log('Unable to load the address!');
                phantom.exit(1);
            } else {

                var repetition = 0;

                var handler = setInterval(function () {

                    repetition++;

                    var loaded = page.evaluate(function () {
                        return window.loadedPdf;
                    });
                    console.log("loaded:" + loaded + " " + address);
                    if (repetition > 300 || ( loaded != null && loaded && loaded=='success') ) {
                        console.log(repetition + "page render cost " + (Date.now() - start) + " ms");
                        start = Date.now();
                        clearInterval(handler);
                        page.render(output);
                        console.log("capture image cost " + (Date.now() - start) + " ms");
                        phantom.exit(0);
                    }
                }, 200);


            }
        });
	}

}catch(e){
	console.log(e+'error');
	phantom.exit();
}