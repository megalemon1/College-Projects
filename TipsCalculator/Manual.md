# Instructions Manual

This is a simple app that uses a check balance and party size to compute the tip and total amounted owed by each memeber
### Inputs
1. The first input, next to Check Amount, is the check balance the user can input. The value can include a decimal value. It won't allow the user to input a negative symbol, so the inputs will stay positive. Leaving the area blank will result in an error message popping up.

2. The second input, next to Party Size, is for how many people will be spliting the check. This value can only be a natural number(1,2,3,4,...). It won't allow the user to input a negative symbol, so the input will stay positve. It also won't allow the user to input a decimal dot to insure the value is a natural number. Inputting a 0 or leaving the area blank will result in an error message popping up.

3. Once valid values for the inputs mentioned above are given, the user can hit the compute button to obtain their result.

### Outputs
1. The app will first take the "Check Amount" and divide it by "Party Size" to get an even split among the party. Then in the row for tips, where it says "Tips:", to the right of each percent value the app will output the tip amount owed for each percentage.

2. In the row for the total, where it says "Total", to the right of each percent value the app will output the total owed including tip for individual choosing that percentage.