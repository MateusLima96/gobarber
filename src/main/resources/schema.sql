CREATE TABLE IF NOT EXISTS appointments (
id UUID PRIMARY KEY,
provider_id UUID,
date TIMESTAMP NOT NULL,
created_at TIMESTAMP NOT NULL DEFAULT NOW(),
updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
foreign key (provider_id) references users (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS users (
id UUID PRIMARY KEY,
name VARCHAR NOT NULL,
email VARCHAR NOT NULL UNIQUE,
password VARCHAR NOT NULL,
created_at TIMESTAMP NOT NULL DEFAULT NOW(),
updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);
