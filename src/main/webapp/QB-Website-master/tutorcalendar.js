webshim.setOptions("forms-ext", {
	"widgets": {
		"startView": 0,
		"minView": 0,
		"inlinePicker": false,
		"size": 1,
		"splitInput": false,
		"yearSelect": false,
		"monthSelect": false,
		"daySelect": false,
		"noChangeDismiss": false,
		"openOnFocus": false,
		"buttonOnly": false,
		"classes": "",
		"popover": {
			//popover options
		},
		"calculateWidth": true,
		"animate": true,
		"toFixed": 0,
		"onlyFixFloat": false
	}
});

//configure forms features
webshim.setOptions("forms", {
	lazyCustomMessages: true,
	replaceValidationUI: true,
	customDatalist: "auto",
	list: {
		"filter": "^"
	}
});

//configure forms-ext features
webshim.setOptions("forms-ext", {
	replaceUI: "auto",
	types: "date range number",
	date: {
		startView: 2,
		openOnFocus: true,
		classes: "show-week"
	},
	number: {
		calculateWidth: false
	},
	range: {
		classes: "show-activevaluetooltip"
	}
});

//load forms and forms-ext features
webshim.polyfill('forms forms-ext');
