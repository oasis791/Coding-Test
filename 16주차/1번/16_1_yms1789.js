function solution(cards) {
    function selectBox(cardsIdx, curIdx, isOpen, boxList){
        let boxNum = [cardsIdx];
        let idx = cardsIdx - 1;
        isOpen[curIdx] = true;
        while(!isOpen[idx]) {
            isOpen[idx] = true;
            boxNum.push(cards[idx]);
            idx = cards[idx] - 1;
        }
        boxList.push(boxNum);   
    }
    
    let answer = [];
    let isOpen = Array(cards.length).fill(false);
    let boxList = [];
    
    selectBox(cards[0], 0, isOpen, boxList);
    
    while(!isOpen.every(ele => ele === true)){
        let idx = isOpen.findIndex(ele => ele === false);
        selectBox(cards[idx], idx, isOpen, boxList);
    }
    for(let box of boxList){
        answer.push(box.length);
    }
    answer.sort((a, b) => b - a);
    return answer.length >= 2 ? answer[0] * answer[1] : 0;
}