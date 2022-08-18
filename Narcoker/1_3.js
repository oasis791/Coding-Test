function solution(array, commands) {
    return commands.reduce(function (result, value) {
        let temp_arr = array.slice(value[0] - 1, value[1]);
        temp_arr.sort((a, b) => (a - b));
        result.push(temp_arr[value[2] - 1]);
        return result;
    }, []);
}