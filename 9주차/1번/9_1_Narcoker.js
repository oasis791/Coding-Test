// [고친 풀이]

function solution(n) {
    return n.toString(2).replaceAll('0', '').length;
}

// [이전 풀이]
// function solution(n) {
//     let count = 0;
//     while (n) {
//         if (n % 2 === 1) {
//             n--;
//             count++;
//         } else
//             n /= 2;
//     }
//     return count
// }