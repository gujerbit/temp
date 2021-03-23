window.onload = function() {
    let main = document.querySelector('.main');
    let mainMenu = main.getElementsByTagName('li');
    console.log(mainMenu);
    let sub = main.getElementsByTagName('ul');
    console.log(sub);

    for(let i = 0; i < 20; i++) {
        if(i % 5 === 0) {
            mainMenu[i].addEventListener('mouseover', function() {
                sub[i / 5].style.display = 'inline';
            });
            mainMenu[i].addEventListener('mouseout', function() {
                sub[i / 5].style.display = 'none';
            });
            sub[i / 5].addEventListener('mouseover', function() {
                sub[i / 5].style.display = 'inline';
            });
            sub[i / 5].addEventListener('mouseout', function() {
                sub[i / 5].style.display = 'none';
            });
        }
    }
}