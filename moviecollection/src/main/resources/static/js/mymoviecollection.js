$(function() {
	// Active Menu
	switch (window.menu) {

		case 'All Movies':
			$('#listMovies').addClass('active');
			break;
		case 'Add Movie':
			$('#addMovie').addClass('active');
			break;

		default:
			if (window.menu == "Home")
				break;
			$('#listMovies').addClass('active');
			$('#gen_' + window.genreId).addClass('active');
			break;
	}

	// jQuery dataTable 

	var $table = $('#movieListTable');

	if ($table.length) {
		var jsonUrl = '';

		if (window.genreId == null) {
			jsonUrl = window.contextRoot + 'json/all/movies';


		} else {
			jsonUrl = window.contextRoot + 'json/genre/' + window.genreId + '/movies';
		}




		$table.DataTable({
			responsive: true,
			language: {
				emptyTable: "There is no movie available in this genre!"
			},
			columnDefs: [
				
				{ responsivePriority: 1, targets: 0 },
				{ responsivePriority: 2, targets: -1 },
				{ responsivePriority: 3, targets: 1 },
				{ responsivePriority: 4, targets: -2 },
				 {"className": "dt-center", "targets": "_all"}
			],
			lengthMenu: [[3, 5, 10, -1], ['3 Records', '5 Records', '10 Records', 'ALL']],
			pageLength: 10,
			ajax: {
				url: jsonUrl,
				dataSrc: ''

			},
			columns: [
				{
					data: 'code',
					bSortable: false,
					mRender: function(data, type, row) {

						return '<img src="' + window.contextRoot + 'images/' + data + '.jpg" class="dataTableImg"/>';
					}

				},
				{
					data: 'name',


				},
				{
					data: 'director',

				},
				{
					data: 'genre.name',

				},

				{
					data: 'languages',
					mRender: function(data, type, row) {

						var txt = '';
						data.forEach(function(item) {
							if (txt.length > 0) {
								txt += ', '
							}
							txt += item.name;
						});
						return txt;
					}

				},

				{
					data: 'castList',
					visible: false,
					mRender: function(data, type, row) {

						var txt = '';

						data.forEach(function(item) {

							if (txt.length > 0) {
								txt += '<br/>'
							}
							txt += item.realFullName;
						});
						return txt;
					}

				},

				{
					data: 'year',

				},

				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row) {
						var str = '';
						str += '<br/> <a href="' + window.contextRoot + 'show/movie/' + data +'" class="btn btn-primary"><i class="fas fa-eye"></i></a> <br/><br/>';
						return str;
					}
				}


			]



		});
	}
	
	// After 3 seconds dismiss the alert 
	var $alert = $('.alert');

	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}


	//Validation 

	var $movieForm = $('#movieForm');

	if ($movieForm.length) {
		$movieForm.validate({

			rules: {
				name: {
					required: true
				},
				director: {
					required: true
				},
				year: {
					required: true,
					min: 1850,
					max: new Date().getFullYear() + 20
				},
				description: {
					required: true
				}

			},
			messages: {
				name: {
					required: 'Please enter the movie name!'
				},
				director: {
					required: 'Please enter the director!'
				},
				year: {
					required: 'Please enter the year!',
					min: 'The year should not be less than 1850!',
					max: 'Please enter a valid year!'

				},
				description: {
					required: 'Please enter the description!'
				}

			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				//add the class of help-block
				error.addClass('help-block');
				//add the error element after the input element 
				error.insertAfter(element);
			}

		});
	}

	var $genreForm = $('#genreForm');

	if ($genreForm.length) {

		$genreForm.validate({

			rules: {

				name: {
					required: true,
					minlength: 2
				}

			},

			messages: {
				name: {
					required: 'Please enter the genre!',
					minlength: 'The genre name should not be less than 2 characters!'
				}
				
			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				//add the class of help-block
				error.addClass('help-block');
				//add the error element after the input element 
				error.insertAfter(element);
			}
		});
	}
	//-------------------------

	// Update the dynamic fields section
	$('.dynamic-update-rows').on('click', 'button[data-dynamic-update-rows-url]', function() {
		
		let url = $(this).data('dynamic-update-rows-url');

		// adding the row index, needed when deleting a dynamic row
		let formData = $('form').serializeArray();
		let param = {};
		param["name"] = $(this).attr('name');
		param["value"] = $(this).val();
		formData.push(param);

		// updating the dynamic section
		$('#dynamicTableContents').load(url, formData);
	});

	
	// Pass show eye
	const togglePassword = document.querySelector('#togglePassword');
	const password = document.querySelector('#password');

	togglePassword.addEventListener('click', function(e) {


		var type = '';
		if (password.getAttribute('type') == 'password') {
			type = 'text';
			$('#show_hide_password i').addClass("fa-eye");
			$('#show_hide_password i').removeClass("fa-eye-slash");
		} else {
			type = 'password';
			$('#show_hide_password i').addClass("fa-eye-slash");
			$('#show_hide_password i').removeClass("fa-eye");
		}

		password.setAttribute('type', type);



	});

});
// Bootbox
$(document).on("click", "#movDelete", function(e) {
     var addressValue = $(this).attr("href");
  	  e.preventDefault();

    bootbox.confirm({
        message: "Are you sure to delete this movie?",
 		centerVertical: true,
		buttons: {
            confirm: {
                label: 'Yes',
                className: 'btn-primary'
            },
            cancel: {
                label: 'No',
                className: 'btn-secondary'
            }
        },
        callback: function (result) {
                if(result==true){
                      window.location = addressValue;
                }

        }

    });
});

