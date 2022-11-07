function solution(n, k) {
    const answer = [];
    const isVisited = new Array(n).fill(false);
    function search(isVisited, order) {
        if (order.length === n) {
            answer.push(order);
            return;
        }
        for (let i = 0; i < n; i++) {
            if (!isVisited[i]) {
                let newIsVisited = [...isVisited];
                let newOrder = [...order];
                newIsVisited[i] = true;
                newOrder.push(i + 1);
                search(newIsVisited, newOrder);
            }
        }
    }

    search(isVisited, []);
    return answer[k];
}
