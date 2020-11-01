package sqlstore

import (
	"database/sql"
	"training/http-rest-api/internal/app/store"

	_ "github.com/lib/pq" // ... import anonymously for preventing importing all methods
)

// Store ...
type Store struct {
	db             *sql.DB
	userRepository *UserRepository
}

// New ...
func New(db *sql.DB) *Store {
	return &Store{
		db: db,
	}
}

// User ...
func (s *Store) User() store.UserRepository {
	if s.userRepository != nil {
		return s.userRepository
	}
	s.userRepository = &UserRepository{
		store: s,
	}

	return s.userRepository
}

//store.User().Create()
