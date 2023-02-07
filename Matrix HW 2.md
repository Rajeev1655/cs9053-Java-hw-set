# Assignment 2

Chen XU cx2214

##### Q1. A= $\begin{bmatrix}1&4&7 \\ 2&5&8 \\ 3&6&9\end{bmatrix}$, What's the null space of A? What's the rank of A? What's the dimension of the null space?

null space refers to $null(A) :Ax = 0$ -> $A = \begin{bmatrix}1&4&7 \\ 2&5&8 \\ 3&6&9\end{bmatrix} \begin{bmatrix}x_1 \\ x_2 \\ x_3\end{bmatrix} = 0$ 

$detA = det\begin{bmatrix}1&4&7 \\ 2&5&8 \\ 3&6&9\end{bmatrix} = det\begin{bmatrix}1&4&7 \\ 1&1&1 \\ 1&1&1\end{bmatrix} = 0$

So there is no null space, and no solution.

rank of A is 3.

dimension is 0.

##### Q2. Prove $detAB = detBA = detAdetB$

First, prove $detAB = detAdetB$: If we transform $detA$ by add/substract one row with another row, we can get a upper-triangular $detA' = detA$. Similarly we can get upper-triangular $detB' = detB$ . If we apply the same transform to $detAB$ we get $detAB = detA'B'$. Since for any "upper-triangular" square matrix, $detM = m_{11}m_{22}..$, $detA'B' = a_{11}b_{11}a_{22}b_{22}... = detA'detB'$. Thus, we have $detAB = detAdetB$.

Similarly, $detB'A' = b_{11}a_{11}b_{22}a_{22}... = detB'detA'= detAB$. Combining these we prove the equation.



##### Q3. Give some simple examples to show that AB!=BA

$A = \begin{pmatrix}0 & 1\\
1 & 1
\end{pmatrix}, B = \begin{pmatrix}1 & 0\\
0 & 2
\end{pmatrix}$

$AB = \begin{pmatrix}0 & 2\\
1 & 2
\end{pmatrix} BA = \begin{pmatrix}0 & 1\\
2 & 2
\end{pmatrix}$

##### Q4. Consider linear equations of the form $x_1+2x_2+3x_3+4x_4=0\newline 2x_1+4x_2+\lambda_1x_3+\lambda_2x_4=0$What is the range of parameters $\lambda_1,\lambda_2$ , for which the equations have nonzero solutions? Also, find all nonzero solution.

Since these are homogeneous equations $Ax=0$, there must be $detA=0$

