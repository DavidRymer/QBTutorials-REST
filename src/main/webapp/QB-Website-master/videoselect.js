window.onload = function() {
	// provs is an object but you can think of it as a lookup table
	var provs = {
			'':[''],
			'Number': ['','Positive and Negative Numbers', 'Number Sequences', 'Rounding', 'Decimals'
				, 'Fractions', 'Matrices', 'Surds', 'Standard Form', 'Percentages'],

				'Algebra': ['','Factorising',
					'Solving Equations',
					'Travel Graphs',
					'Algebraic Fractions',
					'Equation of a Straight Line',
					'Simultaneous Equations',
					'Inequalities',
					'Indices',
					'Quadratic Equations',
					'Functions'], 
					'Ratio, Proportions and Change': ['',
						'Ratios',
						'Proportion',
						'Rates of Change',
						'Compound Measures',
						'Conversions of Area and Volume',
						'Gradients & Graphs',
						'Measurements',
						'Scale Diagrams',
						'Scale Factors',
						'Simple and Compound Interest'],
						'Geometry and measures': ['',

							'Ruler and Compass Constructions',
							'Bearings',
							'Loci',
							'Angles',
							'Angle Theorems',
							'Properties of Polygons',
							'Quadrilaterals',
							'Cyclic Quadrilaterals',
							'Shapes, Symmetry & Tessellation',
							'Transformations',
							'Circle Definitions',
							'Circle Theorem',
							'3D Shapes',
							'Area',
							'Perimeter',
							'Volume',
							'Vectors'],
							'Trigonomety': ['',
								'Sin, Cos, Tan',
								'Pythagoras Theorem',
								'Sine and Cosine Rule',
								'Similar Triangles',
								'Congruency'],
								'Statistics and Probability': ['',
									'Probability',
									'Averages',
									'Standard Deviation',
									'Sampling',
									'Cumulative Frequency Graphs',
									'Representing Data',
									'Histograms']

	},
	// just grab references to the two drop-downs
	prov_select = document.querySelector('#prov'),
	town_select = document.querySelector('#town');

	// populate the provinces drop-down
	setOptions(prov_select, Object.keys(provs));
	// populate the town drop-down
	setOptions(town_select, provs[prov_select.value]);

	// attach a change event listener to the provinces drop-down
	prov_select.addEventListener('change', function() {
		// get the towns in the selected province
		setOptions(town_select, provs[prov_select.value]);
	});

	function setOptions(dropDown, options) {
		// clear out any existing values
		dropDown.innerHTML = '';
		// insert the new options into the drop-down
		options.forEach(function(value) {
			dropDown.innerHTML += '<option name="' + value + '">' + value + '</option>';
		});
	}  
};