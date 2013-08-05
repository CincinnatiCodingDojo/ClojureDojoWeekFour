(ns app.core-test
  (:require [clojure.test :refer :all]
            [app.core :refer :all]))

(deftest test-get-rank
	(is (= "4" 
		(get-rank "4c"))))

(deftest test-get-suit
	(is (= "C" 
		(get-suit "4C"))))

(deftest test-get-values-from-hand
	(is (= ["3" "4" "5" "6" "7"] 
		(get-values-from-hand ["3C" "4C" "5C" "6C" "7C"]))))

(deftest can-find-one-pair
	(is (= true (find-one-pair ["3C" "4C" "5C" "3H" "AH"])))
	(is (= false (find-one-pair ["3C" "3D" "5C" "3H" "AH"])))
	(is (= false (find-one-pair ["3C" "3D" "5C" "5H" "AH"])))
	)


(deftest can-find-three-of-a-kind
	(is (= false (find-three-of-a-kind ["3C" "4C" "5C" "3H" "AH"])))
	(is (= true (find-three-of-a-kind ["3C" "3D" "5C" "3H" "AH"])))
	(is (= false (find-three-of-a-kind ["3C" "3D" "5C" "5H" "AH"])))
	)
