var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
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
    },
    update : function () {
            var data = {
                tag: $('#tag').val(),
                url: $('#url').val(),
                explain: $('#explain').val()
            };
            var index = $('#index').val();
            $.ajax({
                type: 'PUT',
                url: '/api/posts/update/'+index,
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('글이 수정되었습니다.');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
};
main.init();