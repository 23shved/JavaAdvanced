$(document).ready(function() {
	$("button.createProduct").click(function() {
		var name = $("form.createProduct input.productName").val();
		var description = $("form.createProduct input.productDescription").val();
		var price = $("form.createProduct input.productPrice").val();

			var product = {
				name: name,
				description: description,
				price: price
			};
			$.post("productservlet", product, function(data) {
				if (data !== '') {
					$("form")[0].reset();
					$("form")[1].reset();
					alert('Success');
				}
			});
		
	});
});