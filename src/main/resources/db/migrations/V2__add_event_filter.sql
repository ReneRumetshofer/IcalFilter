CREATE TABLE event_filter (
    uuid         UUID         NOT NULL,
    calendar_uuid UUID        NOT NULL,
    filter_type  VARCHAR(255) NOT NULL,
    filter_value TEXT         NOT NULL,

    CONSTRAINT PK_event_filter PRIMARY KEY (uuid),
    CONSTRAINT FK_event_filter_calendar FOREIGN KEY (calendar_uuid) REFERENCES calendar(uuid)
);