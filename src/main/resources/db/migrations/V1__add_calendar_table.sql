CREATE TABLE calendar (
    uuid UUID NOT NULL,
    external_url TEXT NOT NULL,

    CONSTRAINT PK_calendar PRIMARY KEY (uuid)
)