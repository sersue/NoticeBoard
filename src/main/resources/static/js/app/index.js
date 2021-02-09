var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });


    },
    save : function () {
        var data = {
            url: $('#url').val(),
            tag: $('#tag').val(),
            writer: $('#writer').val(),
            explain: $('#explain').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/posts/save',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};
main.init();