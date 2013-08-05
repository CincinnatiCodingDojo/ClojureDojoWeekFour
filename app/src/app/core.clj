(ns app.core)

(defn lazy-contains? [col key] 
  (not= nil (some #{key} col)))

(defn get-rank [card]
	(subs card 0 1))

(defn get-values-from-hand [hand] 
	(map get-rank hand))

(defn find-one-pair [hand] 
	(= (- (count hand) 1)
	   (count (into #{} (get-values-from-hand hand)))))

(defn find-three-of-a-kind [hand]
	 (lazy-contains?  (map count (vals (group-by get-rank hand))) 3))

(defn get-suit [card]
	(subs card 1 2)
	)