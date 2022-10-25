curl -X GET -H "Content-type: application/json" -H "Accept: application/json" -d "{\"operation\":\"get_max_value\"}" http://localhost:8080/numbers
{"max_value":"49999978"}
curl -X GET -H "Content-type: application/json" -H "Accept: application/json" -d "{\"operation\":\"get_min_value\"}" http://localhost:8080/numbers
{"min_value":"-49999996"}
curl -X GET -H "Content-type: application/json" -H "Accept: application/json" -d "{\"operation\":\"get_longest_sequence_increase\"}" http://localhost:8080/numbers
{"longestSequenceIncrease":"[[-48190694, -47725447, -43038241, -20190291, -17190728, -6172572, 8475960, 25205909, 48332507, 48676185]]"}

max 49999978
min -49999996
median 25216
average 7364.41844
longest sequence increase [-48190694, -47725447, -43038241, -20190291, -17190728, -6172572, 8475960, 25205909, 48332507, 48676185]
longest sequence reduction [47689379, 42381213, 30043880, 12102356, -4774057, -5157723, -11217378, -23005285, -23016933, -39209115, -49148762]