package map_test

import "testing"
import "strconv"

const MAP_SIZE = 100

func BenchmarkInsert(b *testing.B) {
	var m = make(map[int]string, MAP_SIZE)

	b.ResetTimer();
	for i := 0; i < b.N; i++ {
		for n := 1; n < MAP_SIZE; n++ {
			m[n] = strconv.Itoa(n)
		}
	}
}

func BenchmarkLookup(b *testing.B) {
	var m = make(map[int]string, MAP_SIZE)
        for n := 1; n < MAP_SIZE; n++ {
		m[n] = strconv.Itoa(n)
        }

        b.ResetTimer()
        for i := 0; i < b.N; i++ {
                for n := 1; n < MAP_SIZE; n++ {
                        var _ = m[n]
                }
        }

}

func BenchmarkDelete(b *testing.B) {
        var orig = make(map[int]string, MAP_SIZE)
        for n := 1; n < MAP_SIZE; n++ {
                orig[n] = strconv.Itoa(n)
        }

        b.ResetTimer()
        for i := 0; i < b.N; i++ {
		var m = make(map[int]string, len(orig))
		for k, v := range m {
			m[k] = v
		}

                for n := 1; n < MAP_SIZE; n++ {
                        delete(m, n)
                }
        }
}

