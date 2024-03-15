{-
Write a function in any functional programming language, e.g., Haskell, Scheme, or F#, that will reverse a general list. 

 

For example, if an input data is (A (B C (D E)) F), the output will be (F ((E D) C B) A).  Please note that any built-in/pre-defined function, e.g., reverse, cannot be used in your answer. 

 

Your code should work with any input data, not just for the sample data (A (B C (D E)) F).

Please DO NOT hard-code any input values, output values in your code.

Language: Haskell
-}

main :: IO ()
main = do
    putStrLn "Input: "
    letters <- getLine
    putStrLn "Reverse: "
    let stack = foldl (\s c -> if c == ')' then '(' : s else if c == '(' then ')' : s else c : s) [] letters
    putStrLn stack


{-
Example inputs:

Input: 
(A (B C (D E)) F)
Reverse: 
(F ((E D) C B) A)

Input: 
1 2 3 (a b (c (d e (f) g) h) i) 4 5 6
Reverse: 
6 5 4 (i (h (g (f) e d) c) b a) 3 2 1

Input: 
1 (a (b c (d e (f g) h (i (j k) l) m) n) o) 2 3 (p (q r (s t (u v) w) x) y) 4 5 6
Reverse: 
6 5 4 (y (x (w (v u) t s) r q) p) 3 2 (o (n (m (l (k j) i) h (g f) e d) c b) a) 1

-}