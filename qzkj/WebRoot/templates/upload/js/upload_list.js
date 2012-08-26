var params;
$(function() {
    $("#file_upload_1").uploadify({
        height        	: 16,
        width         	: 80,
        swf           	: 'templates/uploadify-v3.1/uploadify.swf',
        uploader      	: 'uploadfile.action',
        auto			: true,
        multi			: true,
        fileObjName		: 'file',
        debug			: false,
        method			: 'post',
        formData		: {},
        queueSizeLimit 	: 3,
        buttonText    	: '�ϴ���Ƶ',
        removeCompleted : false,

        onUploadStart: function(file) {//�ϴ���ʼʱ������ÿ���ļ�����һ�Σ�
			params = {"fname" : encodeURIComponent(encodeURIComponent(file.name)), "fsize" : file.size, "ftype" : file.type};
			$('#file_upload_1').uploadify('settings','formData',params);
		},
		onUploadSuccess : function(file,data,response) {//�ϴ����ʱ������ÿ���ļ�����һ�Σ�
			����alert( 'id: ' + file.id
			����+ ' - ����: ' + file.index
			����+ ' - �ļ���: ' + file.name
			����+ ' - �ļ���С: ' + file.size
			����+ ' - ����: ' + file.type
			����+ ' - ��������: ' + file.creationdate
			����+ ' - �޸�����: ' + file.modificationdate
			����+ ' - �ļ�״̬: ' + file.filestatus
			����+ ' - ����������Ϣ: ' + data
			����+ ' - �Ƿ��ϴ��ɹ�: ' + response);
			}
    });
});