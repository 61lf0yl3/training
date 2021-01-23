package decemberchallenge

//CanPlaceFlowers ..
func CanPlaceFlowers(flowerbed []int, n int) bool {
	for i := 0; i < len(flowerbed); i++ {
		if len(flowerbed) > 2 {

			if i == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0 {
				n--
			}
			if i > 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0 {
				n--
				i++
			}
			if i == len(flowerbed)-2 && flowerbed[i] == 0 && flowerbed[i+1] == 0 {
				n--
			}
			if n == 0 {
				return true
			}
		}
	}
	return false
}
