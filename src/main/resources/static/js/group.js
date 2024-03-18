const createGroupButton = document.getElementById('createGroup-btn')

if(createGroupButton){
    createGroupButton.addEventListener('click', event => {
        fetch(`/api/group`, {
                method: 'POST',
                headers: {
                    "Content-Type": "application/json"
                }
        }).then(() => {
            alert('등록 완료되었습니다.');
            location.replace('/articles');
        });
    });
}